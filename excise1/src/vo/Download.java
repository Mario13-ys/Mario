package vo;

public class Download {
private int id;
private String name;
private String path;
private String description;
private long size;
private int star;
private String image;
private String time;
private String sizeStr;	//计算后的资源大小，如50KB，50MB，1. 2G等
public Download(int id, String name, String path, String description, long size, int star, String image, String time,
		String sizeStr) {
	super();
	this.id = id;
	this.name = name;
	this.path = path;
	this.description = description;
	this.size = size;
	this.star = star;
	this.image = image;
	this.time = time;
	this.sizeStr = sizeStr;
}
public Download() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public long getSize() {
	return size;
}
public void setSize(long size) {
	this.size = size;
}
public int getStar() {
	return star;
}
public void setStar(int star) {
	this.star = star;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getSizeStr() {
	return sizeStr;
}
public void setSizeStr(String sizeStr) {
	this.sizeStr = sizeStr;
}

}