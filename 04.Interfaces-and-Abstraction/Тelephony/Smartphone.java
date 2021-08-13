package InterfacesAndAbstraction.Тelephony;

import java.util.List;

public class Smartphone implements Callable, Browsable{
    private List<String> numbers;
    private List<String> urls;

    public List<String> getNumbers() {
        return numbers;
    }

    public List<String> getUrls() {
        return urls;
    }

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        if (urls.isEmpty()) {
            return null;
        }
        String url = urls.remove(0);
        for (int i = 0; i < url.length(); i++) {
            if (Character.isDigit(url.charAt(i))) {
                return "Invalid URL!";
            }
        }
        return String.format("Browsing: %s!", url);
    }

    @Override
    public String call() {
        if (numbers.isEmpty()) {
            return null;
        }
        String number = numbers.remove(0);
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return "Invalid number!";
            }
        }
        return String.format("Calling... %s", number);
    }
}
