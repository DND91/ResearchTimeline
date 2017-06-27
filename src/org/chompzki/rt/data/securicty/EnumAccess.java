package org.chompzki.rt.data.securicty;

public enum EnumAccess {
	NONE(0),
	READ(1),
	WRITE(2),
	ANALYZE(3),
	EVALUATE(4);
			
	private int id;

	EnumAccess(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }
}
