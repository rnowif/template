package com.equinox.template.node;

public interface Node {

    NodeType getType();

    String toHtml();
}
