package com.equinox.template;

import com.equinox.template.node.HtmlNode;
import com.equinox.template.node.Node;

public class TemplateElementBuilder {

    public static Node html() {
        return new HtmlNode();
    }
}
