package com.mins.postup.service;





import com.fasterxml.jackson.core.JsonGenerator;
import com.mins.postup.entity.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    @Autowired
    DataService dataService;

//    @Autowired
//    AllInfoRepogitory allInfoRepogitory;
//



//    @Override
//    public Map findall(String userid) {
//        FindMap resultMap =new FindMap();
//
//
//        Optional<User> tmpuser =userService.findByUserid(userid);
//        User user = tmpuser.get();
//        Long user_id = user.getId();
//
//        List<Board> boardList = boardService.findByUser(user_id);
//
//        if(!boardList.isEmpty()){
//            resultMap.setUser(user);
//
//            List<com.mins.postup.entity.List> listList = listService.findbyBoard(boardList.get(0).getId());
//            if (!listList.isEmpty()){
//                resultMap.
//
//                List<Card> cardList = cardService.findByList(listList.get(0).getId());
//            }
//        }
//
//

//
//        return null ;
//    }
    @PersistenceContext
    public EntityManager em;

    @Override
    public List findall_board_info(Integer board_id) {

        List<com.mins.postup.entity.List> listList = new ArrayList<>();
        List<Card> cardList = new ArrayList<>();
        List<CardContent> cardContentsList = new ArrayList<>();
      
        List resultList = new ArrayList();



        Optional<Board> tmpboard = boardService.findById(board_id);
        Board board = tmpboard.get();




        listList = listService.findbyBoard(board);

        ProcessedBoard pboard_list = null;
        ProcessedBoard pboard_card=null;
        ProcessedBoard pboard_cc=null;

        List ccAlist = new ArrayList();
        List listAList = new ArrayList();
        List cardAList =new ArrayList();




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

//    @Override
//    public List<AllInfo> findall() {
//        allInfoRepogitory.findAll();
//
//
//        return allInfoRepogitory.findAll();
//    }
}
