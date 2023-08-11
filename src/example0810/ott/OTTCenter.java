package example0810.ott;

import java.util.*;

public class OTTCenter implements OnPlay {
    private OTTArchive archive;
    private List<Contents> contentList;
    private List<Media> mediaList;
    public OTTCenter() {
        this.archive = new OTTArchive();
        this.contentList = mapToContents();
        this.mediaList = mapToMediaList();
    }
    public List<Contents> mapToContents() {
        List<Contents> contentList = new ArrayList<>();
        for (Map.Entry<String, Map<String, Object>> entry : archive.getContentM().entrySet()) {
            String id = entry.getKey();
            Map<String, Object> contentData = entry.getValue();
            String title = (String) contentData.get("title");
            String direc = (String) contentData.get("direc");
            String year = (String) contentData.get("year");
            String summary = (String) contentData.get("summary");
            String cast = (String) contentData.get("cast");
            int views = (int) contentData.get("views");
            String typeString = (String) contentData.get("type");
            List<String> mediaIds = (List<String>) contentData.get("medias");
            if ("영화".equals(typeString)) {
                String originalId = mediaIds.get(0);
                String trailerId = mediaIds.get(1);
                contentList.add(new Movie(id, title,direc, year, summary, cast, views, typeString, mediaIds, originalId, trailerId));
            } else if ("시리즈".equals(typeString)) {
                List<String> seriesMediaIds = (List<String>) contentData.get("medias");
                contentList.add(new Series(id, title,direc, year, summary, cast, views, typeString, mediaIds,seriesMediaIds));
            } else {
                contentList.add(new Contents(id, title,direc, year, summary, cast, views, typeString, mediaIds));
            }
        }
        return contentList;
    }
    public List<Media> mapToMediaList() {
        List<Media> mediaList = new ArrayList<>();
        for (Map.Entry<String, Map<String, String>> entry : archive.getMediaM().entrySet()) {
            String mediaId = entry.getKey();
            Map<String, String> mediaData = entry.getValue();
            String title = mediaData.get("title");
            String cId = mediaData.get("cId");
            String time = mediaData.get("time");
            Media media = new Media(mediaId, title, time, cId, this);
            mediaList.add(media);
        }
        return mediaList;
    }

    public List<Contents> contentsRank(){
        List<Contents> contentsRank = new ArrayList<>(contentList);
        Comparator<Contents> comparator = new Comparator<Contents>() {
            @Override
            public int compare(Contents o1, Contents o2) {
                return Integer.compare(o2.getViews(), o1.getViews());
            }
        };
        contentsRank.sort(comparator);
        return contentsRank;
    }
    public void printContents(List<Contents> contents) {
        System.out.println("=========컨텐츠 순위==========");
        for (int i = 0; i < contents.size(); i++) {
            System.out.printf("%d. 제목: %s, 줄거리: %s, 종류: %s%n",
                    i + 1, contents.get(i).getTitle(), contents.get(i).getSummary(), contents.get(i).getType());
        }
        System.out.println("==========================");
    }
    public Map<String, Object> printContentsDetails(int number,List<Contents> contentsRanked) {
        Contents content = contentsRanked.get(number-1);
        List<Media> relatedMedias = new ArrayList<>();

        if(content.getType().equals("영화")){
            System.out.println("제목 : "+ content.getTitle());
            System.out.println("줄거리 : "+ content.getSummary());
            System.out.println("감독 : "+ content.getDirec());
            System.out.println("연도 : "+ content.getYear());
            System.out.println("출연 : "+ content.getCast());
            System.out.println("종류 : "+content.getType());
            System.out.println("0. 찜하기");
            System.out.println();
            int cnt = 0;
            for (int i = 0; i < mediaList.size() ; i++) {
                Media media = mediaList.get(i);
                if(media.getId().equals(((Movie)content).getOriginalId())){
                    cnt++;
                    System.out.println(cnt+".========================");
                    System.out.println("본편 영상");
                    System.out.println("제목 : "+ media.getTitle());
                    System.out.println("영상 시간 : " + media.getTime());
                    relatedMedias.add(media);

                }else if(media.getId().equals(((Movie)content).getTrailerId())){
                    cnt++;
                    System.out.println(cnt+".========================");
                    System.out.println("예고편 영상");
                    System.out.println("제목 : "+ media.getTitle());
                    System.out.println("영상 시간 : " + media.getTime());
                    relatedMedias.add(media);
                }
            }
        }else if(content.getType().equals("시리즈")){
            System.out.println("제목 : "+ content.getTitle());
            System.out.println("줄거리 : "+ content.getSummary());
            System.out.println("감독 : "+ content.getDirec());
            System.out.println("연도 : "+ content.getYear());
            System.out.println("출연 : "+ content.getCast());
            System.out.println("종류 : "+content.getType());
            System.out.println("0. 찜하기");
            System.out.println();
            mediaList.sort(Comparator.comparing(Media::getId));
            for (int i = 0; i < mediaList.size() ; i++) {
                Media media = mediaList.get(i);
                for (int j = 0; j < ((Series)content).getSeriesId().size() ; j++) {
                    if(media.getId().equals(((Series)content).getSeriesId().get(j))) {
                        System.out.println(j+1+ ".========================");
                        System.out.println((j+1)+"회 영상");
                        System.out.println("시리즈 제목 : " + media.getTitle());
                        System.out.println("영상 시간 : " + media.getTime());
                        relatedMedias.add(media);
                    }
                }
            }
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("contents", content);
        resultMap.put("media", relatedMedias);
        return resultMap;
    }

    @Override
    public void playMedia(int playNumber, Map<String, Object> resultMap) {
        Contents selectedContent = (Contents) resultMap.get("contents");
        selectedContent.increaseViews();
        Media selectedMedia = ((List<Media>) resultMap.get("media")).get(playNumber - 1);
        System.out.println(selectedMedia.getTitle() + " 영상이 재생됩니다.");
        printPlayIcon();
    }

    private void printPlayIcon() {
        System.out.println("    .--.   ");
        System.out.println("   ( o o )  ");
        System.out.println("   |  ^  | ");
        System.out.println("   \\~*~*/");
    }


    public List<Contents> showWishList(User user) {
        System.out.println("========== "+user.getName()+"의 위시리스트 =========");
        List<Contents> wishedContents = new ArrayList<>(); // 위시리스트에 있는 컨텐츠들을 저장할 리스트
        List<String> userWished = user.getWishList();
        int cnt = 0;
        for (int i = 0; i < userWished.size() ; i++) {
            for (int j = 0; j < this.contentList.size(); j++) {
                if(contentList.get(j).getId().equals(userWished.get(i))){
                    cnt++;
                    System.out.println(cnt+".========================");
                    System.out.println("제목 : "+contentList.get(j).getTitle());
                    System.out.println("줄거리 : "+contentList.get(j).getSummary());
                    System.out.println("종류 :"+ contentList.get(j).getType());
                    System.out.println("---------------------------");
                    wishedContents.add(contentList.get(j)); // 리스트에 해당 컨텐츠를 추가
                }
            }
        }
        System.out.println("======================================");
        return wishedContents;
    }
    public List<Contents> showMovieList() {
        System.out.println("========영화 목록==========");
        List<Contents> movieContents = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < this.contentList.size(); i++) {
            if(contentList.get(i).getType().equals("영화")){
                cnt++;
                System.out.println(cnt+"-------------------------");
                System.out.println("제목 : "+contentList.get(i).getTitle());
                System.out.println("줄거리 : "+contentList.get(i).getSummary());
                System.out.println("종류 :"+ contentList.get(i).type);
                movieContents.add(contentList.get(i));
            }
        }
        System.out.println("=======================");
        return movieContents;
    }


    public List<Contents> showSeriesList() {
        System.out.println("========시리즈 목록==========");
        List<Contents> seriesContents = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < this.contentList.size(); i++) {
            if(contentList.get(i).getType().equals("시리즈")){
                cnt++;
                System.out.println(cnt+"-------------------------");
                System.out.println("제목 : "+contentList.get(i).getTitle());
                System.out.println("줄거리 : "+contentList.get(i).getSummary());
                System.out.println("종류 :"+ contentList.get(i).type);
                seriesContents.add(contentList.get(i));
            }
        }
        System.out.println("=======================");
        return seriesContents;
    }
}
