package com.equinox.template.node;

public interface Attribute extends Node {

    default NodeType getType() {
        return NodeType.ATTRIBUTE;
    }
}
