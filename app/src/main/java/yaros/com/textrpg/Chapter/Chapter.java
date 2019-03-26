package yaros.com.textrpg.Chapter;

public class Chapter {

    public final int CHAPTER_ID;

    public final int CHAPTER_TEXT;

    public final int[] CHAPTER_VARIANTIDS;

    public Chapter(int CHAPTER_ID, int CHAPTER_TEXT, int[] CHAPTER_VARIANTIDS){
        this.CHAPTER_ID = CHAPTER_ID;
        this.CHAPTER_TEXT = CHAPTER_TEXT;
        this.CHAPTER_VARIANTIDS = CHAPTER_VARIANTIDS;
    }


}
