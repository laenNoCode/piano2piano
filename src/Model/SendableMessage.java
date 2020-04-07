package Model;

public interface SendableMessage {
	public abstract String getContent();
	public abstract void   fromString(String from);
}
