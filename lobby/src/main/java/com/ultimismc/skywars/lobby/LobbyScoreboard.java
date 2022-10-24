package com.ultimismc.skywars.lobby;

import com.ultimismc.skywars.lobby.config.MessageConfigKeys;
import com.ultimismc.skywars.core.user.User;
import com.ultimismc.skywars.core.user.UserStatistics;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import xyz.directplan.directlib.config.replacement.Replacement;
import xyz.directplan.directlib.scoreboard.ScoreboardManager;

import java.util.List;
import java.util.UUID;

/**
 * @author DirectPlan
 */
@RequiredArgsConstructor
public class LobbyScoreboard {

    private final ScoreboardManager scoreboardManager;

    public void updateGameScoreboard(User user) {

        Player player = user.getPlayer();

        String gameDisplayName = MessageConfigKeys.SKYWARS_LOBBY_SCOREBOARD_DISPLAYNAME.getStringValue();
        UserStatistics userStatistics = user.getStatistics();
        int level = userStatistics.getLevel();

        int soloKills = userStatistics.getSoloKills();
        int soloWins = userStatistics.getSoloWins();
        int doublesKills = userStatistics.getDoublesKills();
        int doublesWins = userStatistics.getDoublesWins();

        int coins = userStatistics.getCoins();
        int souls = userStatistics.getSouls();
        int tokens = userStatistics.getTokens();

        List<String> scoreboardLines = MessageConfigKeys.SKYWARS_LOBBY_SCOREBOARD_LINES
                .getStringList(new Replacement("level", level),
                        new Replacement("solo-kills", soloKills),
                        new Replacement("solo-wins", soloWins),
                        new Replacement("doubles-kills", doublesKills),
                        new Replacement("doubles-wins", doublesWins),
                        new Replacement("coins", coins),
                        new Replacement("souls", souls), new Replacement("maximum-souls", 250),
                        new Replacement("tokens", tokens),
                        new Replacement("loot-chests", 0));

        scoreboardManager.sendScoreboard(player, gameDisplayName, scoreboardLines);
    }

    public void removeScoreboard(User user) {
        UUID uuid = user.getUuid();
        scoreboardManager.removeScoreboard(uuid);
    }
}
