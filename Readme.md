# Librairie de templating Java

```
Node node = html(
    head(
        title("MyTitle")
    ),
    body(
        h1("Heading"),
        p("Paragraph")
    )
);

String html = node.toHtml();
```

