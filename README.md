# Pocket4J

## Quick Example

### Prepare

You need properties file of access info.

```properties
consumerKey = xxxxxxxxxxxxxxx
accessToken = xxxxxxxxxxxxxxx
```

### Sample Program

```java
    final PocketClient pocketClient = new PocketClient(ClientInfo.createClientInfo(Path.of("accessInfo.properties")));

    final Conditions conditions = Conditions.defaultConditions()
            .state(UNREAD)
            .contentType(ARTICLE)
            .domain(of("publickey"))
            .count(to(3));

    final List<RetrievedItem> itemList = pocketClient.retrieveData(conditions).getItems().getItemList();

    System.out.println("HIT Count: " + itemList.size());
    itemList.forEach(item -> {
        System.out.println("---------------");
        System.out.println("Item ID: " + item.getItemId());
        System.out.println("URL: " + item.getUrl());
        System.out.println("Title: " + item.getTitle());
        System.out.println("Added: " + item.getAddedDate());
    });
```

