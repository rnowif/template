package com.equinox.template.node;

public interface Element extends Node {

    default NodeType getType() {
        return NodeType.ELEMENT;
    }
}
