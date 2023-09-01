package com.sleeklycoding.filesystem;

import java.util.ArrayList;
import java.util.List;

// Component
interface Node {
    String display(int level);
}

// Leaf
class LeafNode implements Node {
    private String tag;

    public LeafNode(String tag) {
        this.tag = tag;
    }

    @Override
    public String display(int level) {
        return indent(level) + tag + "\n";
    }

    private String indent(int level) {
        return "  ".repeat(level);
    }
}

// Composite
class CompositeNode implements Node {
    private List<Node> children = new ArrayList<>();
    private String tag;

    public CompositeNode(String tag) {
        this.tag = tag;
    }

    public void add(Node child) {
        children.add(child);
    }

    public void remove(Node child) {
        children.remove(child);
    }

    @Override
    public String display(int level) {
        StringBuilder result = new StringBuilder(indent(level) + tag + "/\n");
        for (Node child : children) {
            result.append(child.display(level + 1));
        }
        return result.toString();
    }

    private String indent(int level) {
        return "  ".repeat(level);
    }
}

public class FileSystemScenario {
    public void show() {
        CompositeNode root = new CompositeNode("root");

        CompositeNode documents = new CompositeNode("documents");
        LeafNode doc1 = new LeafNode("doc1.txt");
        LeafNode doc2 = new LeafNode("doc2.txt");
        documents.add(doc1);
        documents.add(doc2);

        CompositeNode pictures = new CompositeNode("pictures");
        LeafNode pic1 = new LeafNode("pic1.jpg");
        LeafNode pic2 = new LeafNode("pic2.jpg");
        pictures.add(pic1);
        pictures.add(pic2);

        documents.add(pictures);
        root.add(documents);

        System.out.println(root.display(0));
    }
}
