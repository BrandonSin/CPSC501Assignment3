package Reflection1Serializable;

public class ObjectReferenceList {
	static final long serialVersionUID=5L;
	ObjectArrayReference[] strRef = new ObjectArrayReference[3];
	
	public ObjectReferenceList(ObjectArrayReference[] objArrayRefSize) {
		this.strRef=objArrayRefSize;
	}


}
