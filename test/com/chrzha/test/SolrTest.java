package com.chrzha.test;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.MapSolrParams;
import org.apache.solr.common.params.SolrParams;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chris Zhang on 2017/7/8.
 */
public class SolrTest {
    public static void main(String[] args) {
        String urlString = "http://localhost:8080/solr/core-test";
        SolrClient solr = new HttpSolrClient(urlString);
        try {
            SolrQuery query = new SolrQuery();
            Map<String, String> pmap = new HashMap<String, String>();
            pmap.put("q", "username:postman");
            pmap.put("rows", "20");
            SolrParams params = new MapSolrParams(pmap);
            query.add(params);
            QueryResponse resp = solr.query(query);
            SolrDocumentList list = resp.getResults();
            System.out.println("===========" + list.size());
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
