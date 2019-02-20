# Marketing Factory DMP extension sample

This project contains an example of extension for Marketing Factory, It provide an implementation of UnomiRequestListener.

This implementation is adding a new Event to enrich the user profile with a new property.

This allow to add custom data in user profiles before the resolution of personalizations, very useful when the personalizations are based on external data.

## Minimal requirements

* DX 7.2.3.2
* Marketing Factory 1.10.2

## Build and deploy

Simply use the following command to build the project and deploy to Jahia

```
mvn clean install jahia:deploy
```

## Installation
Download the jar and deploy it on your instance then activate the module on the site you wish to use it.

## Found a bug?

Please feel free to [create an issue](https://support.jahia.com/) if you find anything wrong with this component.
