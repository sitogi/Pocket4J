package jp.sitogi.pocket.main;

import jp.sitogi.pocket.client.ClientInfo;
import jp.sitogi.pocket.client.PocketClient;
import jp.sitogi.pocket.conditions.Conditions;

import java.nio.file.Path;

import static jp.sitogi.pocket.conditions.Count.to;
import static jp.sitogi.pocket.conditions.Domain.of;

public class Main {

    public static void main(String[] args) throws Exception {
        final PocketClient pocketClient = new PocketClient(
                ClientInfo.createClientInfo(Path.of(".", "accessInfo.properties")));

        final Conditions conditions = Conditions.defaultConditions().domain(of("publickey")).count(to(1));

        pocketClient.retrieveData(conditions);

    }

}
