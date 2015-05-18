package com.equinox.template.node;

import org.junit.Test;

import static com.equinox.template.TemplateElementBuilder.html;
import static org.assertj.core.api.Assertions.assertThat;

public class HtmlNodeTest {

    @Test
    public void should_render_html_node() {
        Node node = html();

        assertThat(node.toHtml()).isEqualTo("<html></html>");
    }

    @Test
    public void should_render_html_node_with_inner_node() {

        Node node = html(new InnerNode());

        assertThat(node.toHtml()).isEqualTo("<html><node></node></html>");
    }
    
    @Test
    public void should_render_html_node_with_attribute() {

        Node node = html(new AttributeNode());

        assertThat(node.toHtml()).isEqualTo("<html lang=\"fr\"></html>");
    }

    @Test
    public void should_render_html_node_with_multiple_inner_nodes() {
        Node node = html(new InnerNode(), new InnerNode());

        assertThat(node.toHtml()).isEqualTo("<html><node></node><node></node></html>");
    }

    @Test
    public void should_render_html_node_with_multiple_attributes() {
        Node node = html(new AttributeNode(), new AttributeNode());

        assertThat(node.toHtml()).isEqualTo("<html lang=\"fr\" lang=\"fr\"></html>");
    }

    private static class InnerNode implements Element {

        @Override
        public String toHtml() {
            return "<node></node>";
        }
    }

    private static class AttributeNode implements Attribute {

        @Override
        public String toHtml() {
            return "lang=\"fr\"";
        }
    }

}
