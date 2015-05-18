package com.equinox.template.node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElementImpl implements Element {

    private static final String EMPTY_NODE = "";
    private final String name;

    private List<Node> innerNodes = new ArrayList<>();

    public ElementImpl(String name, Node... nodes) {
        this.innerNodes = Arrays.asList(nodes);
        this.name = name;
    }

    public String toHtml() {

        String innerHtml = innerNodes.stream()
                .filter((node -> NodeType.ELEMENT.equals(node.getType())))
                .map(Node::toHtml)
                .reduce(String::concat)
                .orElse(EMPTY_NODE);

        String attributesHtml = innerNodes.stream()
                .filter((node -> NodeType.ATTRIBUTE.equals(node.getType())))
                .map(Node::toHtml)
                .reduce((s, s2) -> s + " " + s2)
                .orElse(EMPTY_NODE);

        StringBuilder sb = new StringBuilder();
        sb.append("<").append(name);
        if (!attributesHtml.isEmpty()) {
            sb.append(" ").append(attributesHtml);
        }
        sb.append(">");
        sb.append(innerHtml);
        sb.append("</").append(name).append(">");

        return sb.toString();
    }
}
