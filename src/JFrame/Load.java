package JFrame;

public class Load {
    public static void main(String[] args){
        LoadingFrame load = new LoadingFrame();
        load.setVisible(true);
        SignUpPage m = new SignUpPage();
        
        try {
            for (int i = 0; i<=100; i++){
                Thread.sleep(40);
                load.lbl_loading.setText(Integer.toString(i) + "%");
                load.prose.setValue(i);
                if(i == 100){
                    load.setVisible(false);
                    m.setVisible(true);
                }
            }
        } catch (Exception e) {
        }
        
    }
}
