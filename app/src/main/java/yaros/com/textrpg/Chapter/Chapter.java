package yaros.com.textrpg.Chapter;

public class Chapter implements IChapter {

    public final int CHAPTER_ID;

    public final int CHAPTER_TEXT;

    public final int[] CHAPTER_VARIANTIDS;

    public final int[] CHAPTER_VARIANTTEXTIDS;

    public Chapter(int CHAPTER_ID, int CHAPTER_TEXT, int[] CHAPTER_VARIANTIDS, int[] CHAPTER_VARIANTTEXTIDS){
        this.CHAPTER_ID = CHAPTER_ID;
        this.CHAPTER_TEXT = CHAPTER_TEXT;
        this.CHAPTER_VARIANTIDS = CHAPTER_VARIANTIDS;
        this.CHAPTER_VARIANTTEXTIDS = CHAPTER_VARIANTTEXTIDS;
    }


}
