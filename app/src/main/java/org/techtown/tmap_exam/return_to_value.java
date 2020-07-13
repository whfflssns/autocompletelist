//package org.techtown.tmap_exam;
//
//import android.os.AsyncTask;
//
//import com.skt.Tmap.TMapData;
//import com.skt.Tmap.TMapPOIItem;
//
//import java.util.ArrayList;
//
//public class return_to_value extends AsyncTask {
//    String word;
//    private ArrayList<Search_Entity> mListData;
//    private ArrayList<Search_Entity> mListData1;
//
//    public return_to_value(String word) {
//        this.word = word;
//        mListData = new ArrayList<Search_Entity>();
//    }
//
//    @Override
//    protected Object doInBackground(Object[] objects) {
//        TMapData tmapdata = new TMapData();
//        try {
//            tmapdata.findAllPOI(word, new TMapData.FindAllPOIListenerCallback() {
//                @Override
//                public void onFindAllPOI(ArrayList poiItem) {
//                    for(int i = 0; i < poiItem.size(); i++) {
//                        TMapPOIItem item = (TMapPOIItem) poiItem.get(i);
//                        String fullAddr = item.upperAddrName + " " + item.middleAddrName +
//                                " " + item.lowerAddrName + " " + item.detailAddrName;
//
//                        mListData.add(new Search_Entity( item.getPOIName(), fullAddr));
//                    }
//                }
//            });
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return mListData;
//    }
//
//    @Override
//    protected void onPostExecute(ArrayList<Search_Entity> autoCompleteItems) {
//        mListData1.set();
//    }
//}
