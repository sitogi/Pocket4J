# Pocket4J

## Quick Example
```java
    final PocketClient pocketClient = new PocketClient(
            ClientInfo.createClientInfo(Path.of(".", "accessInfo.properties")));

    final Conditions conditions = Conditions.defaultConditions()
            .state(UNREAD)
            .contentType(ARTICLE)
            .domain(of("publickey"))
            .count(to(3));

    final List<RetrievedItem> itemList = pocketClient.retrieveData(conditions).getItems().getItemList();

    System.out.println("HIT Count: " + itemList.size());
    for (final RetrievedItem retrievedItem : itemList) {
        System.out.println("---------------");
        System.out.println("Item ID: " + retrievedItem.getItemId());
        System.out.println("URL: " + retrievedItem.getUrl());
        System.out.println("Title: " + retrievedItem.getTitle());
        System.out.println("Added: " + retrievedItem.getAddedDate());
    }
```

