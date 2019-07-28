package jp.sitogi.pocket.main;

import jp.sitogi.pocket.client.ClientInfo;
import jp.sitogi.pocket.client.PocketClient;
import jp.sitogi.pocket.client.RetrievedItem;
import jp.sitogi.pocket.conditions.Conditions;

import java.nio.file.Path;
import java.util.List;

import static jp.sitogi.pocket.conditions.ContentType.ARTICLE;
import static jp.sitogi.pocket.conditions.Count.to;
import static jp.sitogi.pocket.conditions.Domain.of;
import static jp.sitogi.pocket.conditions.State.UNREAD;

public class Main {

    public static void main(String[] args) throws Exception {
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
    }

}
