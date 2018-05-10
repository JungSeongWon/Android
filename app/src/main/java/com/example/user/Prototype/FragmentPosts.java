package com.example.user.Prototype;

import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 2018-04-04.
 */

public class FragmentPosts extends Fragment {

    View view;
    String url = "http://cug.accessict.co.kr/addon/99999999/FR-0007.asp?strLoginID=jyk7141&strGroup=G001&intPage=1 ";
   // TextView postText;
    RecyclerView recyclerView;

    List<PostModel> postModelList = new ArrayList<>();
    PostListAdapter postListAdapter = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final RequestQueue queue = HttpVolley.getInstance(getActivity()).getRequestQueue();

        view = inflater.inflate(R.layout.fragment_posts, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        //ostText = (TextView) view.findViewById(R.id.postText);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(),networkSuccessListener(),networkErrorListener());
        queue.add(jsonObjectRequest);


     //   NetworkTask networkTask = new NetworkTask(url, null);
     //   networkTask.execute();


        return view;

    }

    private Response.Listener<JSONObject> networkSuccessListener(){
        return new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
              //  StringBuilder from_server = new StringBuilder();

                try {
                    //from_server = response.getString("snackchat");
                    JSONArray ja = response.getJSONArray("snackchat");
                    for(int i=0; i<ja.length(); i++){
                        postModelList.add(new PostModel(ja.getJSONObject(i).getString("strSubject"),ja.getJSONObject(i).getString("dateRegDate"),ja.getJSONObject(i).getString("strName")));

                       // String strSubject = ja.getJSONObject(i).getString("strSubject");
                        //String dateRegDate = ja.getJSONObject(i).getString("dateRegDate");
                        //String strName = ja.getJSONObject(i).getString("strName");



                      //  from_server.append("게시글 명 : " + strSubject +"\n");
                       // from_server.append("게시자 : " + strName+"\n");
                       // from_server.append("시간 : " +dateRegDate +"\n\n");
                    }

                    postListAdapter = new PostListAdapter(postModelList);
                    recyclerView.setAdapter(postListAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
              //  postText.setText(from_server);
            }
        };
    }

    private Response.ErrorListener networkErrorListener(){
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(),"network error",Toast.LENGTH_SHORT).show();
            }
        };
    }


   /* public void getContents(final Context mContext, final SynchroListModel obj, final boolean isFirst, final boolean isSelect) {
        HttpConnect httpConnect = new HttpConnect(mContext);
        httpConnect.requestJson(obj.getStrJsonLink(), new JsonListener() {
            @Override
            public void onError(int code, String error) {

            }

            @Override
            public void onResult(JSONObject jsonObject) {
                try {

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }*/

   /* public class NetworkTask extends AsyncTask<Void, Void, String> {
        private String url;
        private ContentValues values;

        public NetworkTask(String url, ContentValues values) {

            this.url = url;
            this.values = values;
        }

        @Override
        protected String doInBackground(Void... params) {

            String result; // 요청 결과를 저장할 변수.
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            postText.setText(s);
        }
    }*/
}

