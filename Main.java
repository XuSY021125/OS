
public class Main {
    public static void main(String[] args) {
        int frameSize = 3;
        ClockAlgorithm clock = new ClockAlgorithm(frameSize);

        // 引用一系列页面
        int[] pageReferences = {1, 2, 3, 3, 1, 2, 5, 1, 2, 2, 4, 5};
        for (int pageId : pageReferences) {
            clock.referencePage(pageId);
            System.out.println("Referenced Page: " + pageId);
            System.out.println("Page Frames: " + clock.pageFrames);
            System.out.println();
        }
    }
}

