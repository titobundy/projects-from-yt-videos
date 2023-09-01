package com.sleeklycoding.html;

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
        return indent(level) + "<" + tag + "/>\n";
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
        StringBuilder result = new StringBuilder(indent(level) + "<" + tag + ">\n");
        for (Node child : children) {
            result.append(child.display(level + 1));
        }
        result.append(indent(level) + "</" + tag + ">\n");
        return result.toString();
    }

    private String indent(int level) {
        return "  ".repeat(level);
    }
}

public class HtmlScenario {
    public void show() {
        CompositeNode root = new CompositeNode("html");

        CompositeNode body = new CompositeNode("body");
        LeafNode img1 = new LeafNode("img");
        LeafNode img2 = new LeafNode("img");
        body.add(img1);
        body.add(img2);

        CompositeNode div = new CompositeNode("div");
        LeafNode input1 = new LeafNode("input");
        LeafNode input2 = new LeafNode("input");
        div.add(input1);
        div.add(input2);

        body.add(div);
        root.add(body);

        System.out.println(root.display(0));
    }
}