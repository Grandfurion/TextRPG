package yaros.com.textrpg.ChaptersCreator;

import java.util.HashMap;

import yaros.com.textrpg.Chapter.Chapter;

public interface IChaptersCreator {

    HashMap<Integer, Chapter> Generate();

}
