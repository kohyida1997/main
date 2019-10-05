package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.game.Game;
import seedu.address.model.Model;
import seedu.address.model.deck.Deck;
import seedu.address.model.deck.DeckBuilder;

import static seedu.address.model.deck.DeckBuilder.japanCard;
import static seedu.address.model.deck.DeckBuilder.singaporeCard;
import static seedu.address.model.deck.DeckBuilder.malaysiaCard;
import static seedu.address.model.deck.DeckBuilder.damithCard;

public class StartCommand extends GameCommand {

    public static final String COMMAND_WORD = "start";
    public static final String MESSAGE_GAME_START_SUCCESS = "Sample game session in progress, ";
    public static final String FIRST_QUESTION_MESSAGE = "guess the keyword! ";

    public StartCommand() {

    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        Deck dummyDeck = DeckBuilder.makeNewDeck(singaporeCard, malaysiaCard, japanCard, damithCard);
        Game newGame = new Game(dummyDeck);
        model.setGame(newGame);
        String currQuestion = model.getGame().showCurrQuestion();
        return new CommandResult(
                MESSAGE_GAME_START_SUCCESS + FIRST_QUESTION_MESSAGE
                        + "\n"
                        + currQuestion
                , true);
    }
}
