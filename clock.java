import java.util.ArrayList;
import java.util.List;

public class ClockAlgorithm {
    private static class Page {
        int id;
        boolean referenced;

        Page(int id) {
            this.id = id;
            referenced = false;
        }
    }

    List<Page> pageFrames;
    private int hand;

    public ClockAlgorithm(int frameSize) {
        pageFrames = new ArrayList<>(frameSize);
        for (int i = 0; i < frameSize; i++) {
            pageFrames.add(null);
        }
        hand = 0;
    }

    public void referencePage(int pageId) {
        // 查找页面是否已在页框中
        for (Page page : pageFrames) {
            if (page != null && page.id == pageId) {
                page.referenced = true;
                return;
            }
        }

        // 页面不在页框中，进行页面置换
        while (true) {
            Page currentPage = pageFrames.get(hand);
            if (currentPage == null || !currentPage.referenced) {
                // 找到未被引用的页面或空页框，进行替换
                pageFrames.set(hand, new Page(pageId));
                hand = (hand + 1) % pageFrames.size();
                return;
            } else {
                // 将当前页面的引用标记重置为false
                currentPage.referenced = false;
            }
            hand = (hand + 1) % pageFrames.size();
        }
    }
}
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

