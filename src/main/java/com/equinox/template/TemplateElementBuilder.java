package com.equinox.template;

import com.equinox.template.node.ElementImpl;
import com.equinox.template.node.Node;

public class TemplateElementBuilder {

    public static Node html(Node... nodes) {
        return new ElementImpl("html", nodes);
    }
}
