package com.mojang.realmsclient.dto;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.realmsclient.util.JsonUtils;
import java.util.List;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@OnlyIn(Dist.CLIENT)
public class RealmsServerPlayerList extends ValueObject {
   private static final Logger LOGGER = LogManager.getLogger();
   private static final JsonParser JSON_PARSER = new JsonParser();
   public long serverId;
   public List<String> players;

   public static RealmsServerPlayerList parse(JsonObject p_230785_0_) {
      RealmsServerPlayerList realmsserverplayerlist = new RealmsServerPlayerList();

      try {
         realmsserverplayerlist.serverId = JsonUtils.getLongOr("serverId", p_230785_0_, -1L);
         String s = JsonUtils.getStringOr("playerList", p_230785_0_, (String)null);
         if (s != null) {
            JsonElement jsonelement = JSON_PARSER.parse(s);
            if (jsonelement.isJsonArray()) {
               realmsserverplayerlist.players = parsePlayers(jsonelement.getAsJsonArray());
            } else {
               realmsserverplayerlist.players = Lists.newArrayList();
            }
         } else {
            realmsserverplayerlist.players = Lists.newArrayList();
         }
      } catch (Exception exception) {
         LOGGER.error("Could not parse RealmsServerPlayerList: " + exception.getMessage());
      }

      return realmsserverplayerlist;
   }

   private static List<String> parsePlayers(JsonArray p_230784_0_) {
      List<String> list = Lists.newArrayList();

      for(JsonElement jsonelement : p_230784_0_) {
         try {
            list.add(jsonelement.getAsString());
         } catch (Exception exception) {
         }
      }

      return list;
   }
}