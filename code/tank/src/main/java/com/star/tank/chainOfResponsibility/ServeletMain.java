package com.star.tank.chainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

public class ServeletMain {
    public static void main(String[] args) {



        NewsControl nc = new NewsControl();
        Request request = new Request();
        request.msg = "我是一个请求";
        request.token = "123456";
        Response response = new Response();
        response.msg = "我是一个回应";
        response.msg = request.token;

        TokenFilter tokenFilter = new TokenFilter();
        KeyFilter keyFilter = new KeyFilter();
        FilterChain fc = new FilterChain();
        fc.add(tokenFilter).add(keyFilter);
        fc.doFilter(request,response);

        nc.save(request,response);
    }
}

class NewsControl{
    public String save(Request request,Response response){
        return "";
    }
}

class Request{
    public String token;
    public String msg;
}
class Response{
    public String token;
    public String msg;
}

interface Filter{
    public void doFilter(Request request,Response response,FilterChain filterChain);
}

class FilterChain implements Filter{
    public List<Filter> filters = new ArrayList<Filter>();

    public FilterChain add(Filter filter){
        filters.add(filter);
        return this;
    }
    private int i = -1;
    private boolean income = true;

    public void doFilter(Request request, Response response) {
        if(income)
            i++;
        else
            i--;
        if(income&&i==filters.size()-1)
            income = false;
        filters.get(i).doFilter(request,response,this);
    }

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        this.doFilter(request,response);
    }
}

class TokenFilter implements Filter{

    @Override
    public void doFilter(Request request, Response response,FilterChain filterChain) {


        filterChain.doFilter(request,response);
    }


}

class KeyFilter implements Filter{

    @Override
    public void doFilter(Request request, Response response,FilterChain filterChain) {


        filterChain.doFilter(request,response);
    }
}
