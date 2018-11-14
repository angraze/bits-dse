package in.aa.dse.dsad;

public class Node {
    private String title;
    private String duration;
    private Node left;
    private Node right;

    public Node(String title, String duration) {
        this.title = title;
        this.duration = duration;
    }

    public Node next() {
        return right;
    }

    public Node previous() {
        return left;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
