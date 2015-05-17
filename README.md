# iconlib

Made this small library because I use this in almost all my GUI applications

Contains quick methods for getting resources as icons and caching them in memory

## Examples

Getting an icon

```java
JLabel label = new JLabel("Example");
label.setIcon(IconUtils.getIcon("icon")); // icon located in resource /icons/icon.png
```

Getting an icon from another resource location

```java
JLabel label = new JLabel("Example");
label.setIcon(IconUtils.getIcon("/folder/image.png", false)); // icon located in resource /folder/image.png
```