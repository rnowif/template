package com.equinox.template.node;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HtmlNodeTest {

    @Test
    public void should_render_html_node() {
        Node node = new HtmlNode();

        assertThat(node.toHtml()).isEqualTo("<html></html>");
    }

}
