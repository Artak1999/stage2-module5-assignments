package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName = "";
    private Long period = 10_000_000_000_000L;
    private StringBuilder processorVersion = new StringBuilder();
    private Integer valueOfCheap = 0;
    private Scanner informationScanner;
    private List<String> stringArrayList = new ArrayList<>(0);

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, List<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion.append(processorVersion != null ? processorVersion : "");
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        for (String string : stringList)
            Optional.ofNullable(string).map(String::hashCode).ifPresent(System.out::println);
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(LinkedList<String> stringList) {
        StringJoiner joiner = new StringJoiner(" ", processorName, "");
        for (String string : stringList) {
            joiner.add(string);
        }
        return joiner.toString();
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        informationScanner = new Scanner(file);
        try {
            while (informationScanner.hasNext()) {
                processorVersion.append(informationScanner.nextLine());
            }
        } finally {
            informationScanner.close();
        }
    }
}
