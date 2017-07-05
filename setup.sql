
-- Objects (normalId, secutiryId, etc)
-- Users
-- Organisations
-- Timelines
-- Events
-- Resources
-- Contents
-- Tags
-- EventRelations

-- Users(userId, securityId, name)

-- Securitys (securityId, access)
-- SecurityGroups (groupId, name)
-- Memberships (userId, groupId)

-- UserAccess (userId, access, securityId)
-- GroupAccess (groupId, access, securityId)


DELIMITER //

DROP TRIGGER IF EXISTS `t_Users`//
DROP TRIGGER IF EXISTS `t_Securitys`//
DROP TRIGGER IF EXISTS `t_SecurityGroups`//


DROP TABLE IF EXISTS `UserAccess`, `GroupAccess`, `Memberships`, `Users`, `Securitys`, `SecurityGroups` //

# SECURITY

CREATE TABLE `Securitys` (
	`securityId` BINARY(16) NOT NULL,
    `type` VARCHAR(128) NOT NULL,
    `access` INTEGER NOT NULL,
    PRIMARY KEY(`securityId`)	
)//

CREATE TRIGGER `t_Securitys` BEFORE INSERT ON `Securitys`
 FOR EACH ROW BEGIN
 SET NEW.securityId = UNHEX(REPLACE(UUID(),'-',''));
END//

# SECURITY GROUP

CREATE TABLE `SecurityGroups` (
	`groupId` BINARY(16) NOT NULL,
    `name` VARCHAR(64) NOT NULL,
    PRIMARY KEY(`groupId`)	
)//

CREATE TRIGGER `t_SecurityGroups` BEFORE INSERT ON `SecurityGroups`
 FOR EACH ROW BEGIN
 SET NEW.groupId = UNHEX(REPLACE(UUID(),'-',''));
END//

# USER

CREATE TABLE `Users` (
	`userId` BINARY(16) NOT NULL,
    `securityId` BINARY(16) NOT NULL,
    `name` VARCHAR(64) NOT NULL,
    PRIMARY KEY(`userId`),
    FOREIGN KEY (`securityId`) REFERENCES `Securitys`(`securityId`)
)//

CREATE TRIGGER `t_Users` BEFORE INSERT ON `Users`
FOR EACH ROW 
BEGIN
	SET NEW.userId = UNHEX(REPLACE(UUID(),'-',''));
	INSERT INTO `Securitys`(`access`) VALUES (0);
    SET NEW.securityId = LAST_INSERT_ID(); 
END//

# USER ACCESS

CREATE TABLE `UserAccess` (
	`userId` BINARY(16) NOT NULL,
    `access` INTEGER NOT NULL,
    `securityId` BINARY(16) NOT NULL,
    FOREIGN KEY (`userId`) REFERENCES `Users`(`userId`),
    FOREIGN KEY (`securityId`) REFERENCES `Securitys`(`securityId`)
)//

# GROUP MEMBERSHIP

CREATE TABLE `Memberships` (
	`userId` BINARY(16) NOT NULL,
    `groupId` BINARY(16) NOT NULL,
    FOREIGN KEY (`userId`) REFERENCES `Users`(`userId`),
    FOREIGN KEY (`groupId`) REFERENCES `SecurityGroups`(`groupId`)
)//

# GROUP ACCESS

CREATE TABLE `GroupAccess` (
	`groupId` BINARY(16) NOT NULL,
    `access` INTEGER NOT NULL,
    `securityId` BINARY(16) NOT NULL,
    FOREIGN KEY (`groupId`) REFERENCES `SecurityGroups`(`groupId`),
    FOREIGN KEY (`securityId`) REFERENCES `Securitys`(`securityId`)
)//




























