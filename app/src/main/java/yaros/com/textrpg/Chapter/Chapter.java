package yaros.com.textrpg.Chapter;

public class Chapter implements IChapter {

    public final int CHAPTER_TEXT_IDS;

    public final int[] CHAPTER_VARIANTIDS;

    //public final int[] CHAPTER_VARIANTTEXTIDS;

    public final boolean isBattle;

    public Chapter(int CHAPTER_TEXT_IDS, int[] CHAPTER_VARIANTIDS, /*int[] CHAPTER_VARIANTTEXTIDS,*/ boolean isBattle){
        this.CHAPTER_TEXT_IDS = CHAPTER_TEXT_IDS;
        this.CHAPTER_VARIANTIDS = CHAPTER_VARIANTIDS;
        //this.CHAPTER_VARIANTTEXTIDS = CHAPTER_VARIANTTEXTIDS;
        this.isBattle = isBattle;
    }


}
