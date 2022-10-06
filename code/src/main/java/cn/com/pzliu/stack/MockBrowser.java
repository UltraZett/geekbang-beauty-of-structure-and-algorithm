package cn.com.pzliu.stack;

public class MockBrowser {

    private StackBasedOnArray<String> forward = new StackBasedOnArray<>(10);


    private StackBasedOnArray<String> back = new StackBasedOnArray<>(10);

    private String url;

    public StackBasedOnArray<String> getForward() {
        return forward;
    }

    public StackBasedOnArray<String> getBack() {
        return back;
    }

    public String getUrl() {
        return url;
    }

    public void browser(String url){
        if (this.url != null && this.url !=""){
            back.push(this.url);
        }
        this.url = url;
    }

    public void forward(){
        if (this.url != null && this.url !=""){
            back.push(url);
        }
        this.url = forward.pop();
    }

    public void back(){
        if (this.url != null && this.url !=""){
            forward.push(url);
        }
        this.url = back.pop();
    }




    public static void main(String[] args) {
        MockBrowser mockBrowser = new MockBrowser();
        mockBrowser.browser("www.javmoo.com");
        mockBrowser.browser("www.javzoo.com");
        mockBrowser.browser("www.javaoo.com");
        mockBrowser.browser("www.javbus.com");
        System.out.println(mockBrowser.url);
        System.out.println(mockBrowser.back);
        System.out.println(mockBrowser.forward);
        mockBrowser.back();
        System.out.println(mockBrowser.url);
        mockBrowser.back();
        System.out.println(mockBrowser.url);
        System.out.println(mockBrowser.back);
        System.out.println(mockBrowser.forward);
        mockBrowser.forward();
        System.out.println(mockBrowser.url);
        System.out.println(mockBrowser.back);
        System.out.println(mockBrowser.forward);
    }



}
