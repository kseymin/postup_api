package com.mins.postup.service;





import com.mins.postup.entity.*;
import com.mins.postup.model.ProcessedBoard;
import com.mins.postup.model.ProcessedCard;
import com.mins.postup.model.ProcessedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.List;


@Service
public class FindServiceImpl implements FindService {
    @Autowired
    UserService userService;

    @Autowired
    BoardService boardService;

    @Autowired
    ListService listService;

    @Autowired
    CardService cardService;

    @Autowired
    CardContentService cardContentService;




    //Join datas
    @Override
    public List findall_board_info(Integer board_id) {


        ProcessedBoard pboard_list = null;
        ProcessedBoard pboard_card=null;
        ProcessedBoard pboard_cc=null;

        List<com.mins.postup.entity.List> listList = new ArrayList<>();
        List<Card> cardList = new ArrayList<>();
        List<CardContent> cardContentsList = new ArrayList<>();


        List ccAlist = new ArrayList();
        List listAList = new ArrayList();
        List cardAList =new ArrayList();

        List resultList = new ArrayList();

        Optional<Board> tmpboard = boardService.findById(board_id);
        Board board = tmpboard.get();

        listList = listService.findbyBoard(board);

        for (com.mins.postup.entity.List list : listList) {


            pboard_list = new ProcessedBoard(list.getId(), list.getName());
            listAList.add(pboard_list);


            cardList = cardService.findByList(list);
            if (!cardList.isEmpty()) {



                for (Card card : cardList) {
                    pboard_card = new ProcessedBoard(list.getId(), list.getName());
                    pboard_card.setCard_id(card.getId());
                    pboard_card.setCard_name(card.getName());
                    pboard_card.setCard_description(card.getDescription());

                    cardContentsList = cardContentService.findbyCard(card);

                    cardAList.add(pboard_card);


                    if (!cardContentsList.isEmpty()) {


                        for (CardContent cc : cardContentsList) {
                            pboard_cc = new ProcessedBoard(list.getId(), list.getName());
                            pboard_cc.setCard_id(card.getId());
                            pboard_cc.setCard_name(card.getName());
                            pboard_cc.setCard_description(card.getDescription());

                            pboard_cc.setCardcontent_id(cc.getId());
                            pboard_cc.setCardcontent_name(cc.getName());
                            pboard_cc.setCardcontent_contents(cc.getContents());

                            ccAlist.add(pboard_cc);

                        }

                    }

                }

            }

            if (ccAlist.isEmpty()&&cardAList.isEmpty()){
                resultList.add(listAList);
            }else if (ccAlist.isEmpty()){
                resultList.add(cardAList);
            }else{
                resultList.add(ccAlist);
            }

            listAList = new ArrayList();
            cardAList = new ArrayList();
            ccAlist = new ArrayList();
        }


        return resultList;
    }



    //not join used model
    @Override
    public Object findall_board(Integer board_id) {
        Optional<Board> tmpboard = boardService.findById(board_id);
        Board board = tmpboard.get();
        //보드 가져옴

        List resultlist = new ArrayList();
        //결과값


        //List tmpList_card =new ArrayList();
        ArrayList<HashMap<String,Object>> tmpList_card = new ArrayList<>();
        ArrayList<HashMap<String,Object>>  tmpList_cc = new ArrayList() ;
        //카드와 카드콘텐츠를 맵형식으로 넣는데 그 맵을 저장하기위한 리스트



        List tmpCCardList =new ArrayList();
        List testList = new ArrayList();
        //카드콘텐츠 임시저장용


        HashMap<String, Object> mapDepth1 ;
        HashMap<String, Object> mapDepth1_cc ;
        HashMap<String, Object> mapDepth2 ;
        //카드 와 카드 컨텐츠를 임시적으로 만들기위한 맵



        List<com.mins.postup.entity.List> listList ;
        List<Card> cardList ;
        List<CardContent> cardContentsList = new ArrayList<>();
        //보드,카드,카드콘텐츠를 검색할때 사용


        ProcessedList pList;
        ProcessedCard pcard = new ProcessedCard();
        ProcessedCard pCC = new ProcessedCard();
        //각각 리스트,카드,카드컨텐츠 에 해당하는 클래스를 새로만들었으며
        //이를 이용해 최종 전달할 폼을 지정한다.




        listList=listService.findbyBoard(board);
        for (com.mins.postup.entity.List list:listList){

            pList = new ProcessedList(list.getId(),list.getName());


            cardList=cardService.findByList(list);
            for (Card card:cardList) {
                mapDepth1 = new HashMap<>();

                mapDepth1.put("card_id",card.getId());
                mapDepth1.put("card_name",card.getName());
                mapDepth1.put("card_description",card.getDescription());

                //add null info for prontend
                mapDepth1.put("cardcontentlist",null);

                tmpList_card.add(mapDepth1);

                pcard = new ProcessedCard(list.getId(),list.getName(),tmpList_card);

                cardContentsList=cardContentService.findbyCard(card);
                for(CardContent cc:cardContentsList){
                    mapDepth1_cc = new HashMap<>();

                    //mapDepth1_cc.put("card_id",cc.getCard().getId());
                    mapDepth1_cc.put("cardcontent_id",cc.getId());
                    mapDepth1_cc.put("cardcontent_name",cc.getName());
                    mapDepth1_cc.put("cardcontent_content",cc.getContents());

                    tmpList_cc.add(mapDepth1_cc);

                    mapDepth1.put("cardcontentlist",tmpList_cc);

                    pCC = new ProcessedCard(list.getId(),list.getName(),tmpList_card);

                }


                //초기화
                tmpList_cc = new ArrayList();

            }



            if (cardContentsList.isEmpty()&&cardList.isEmpty()){
                resultlist.add(pList);
            }else if (cardContentsList.isEmpty()){

                resultlist.add(pcard);
            }else{
                resultlist.add(pCC);
            }

            tmpList_card = new ArrayList();
            tmpList_cc = new ArrayList();

        }



        return resultlist;
    }


}
