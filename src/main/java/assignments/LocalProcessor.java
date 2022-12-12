package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Scanner;
import java.util.StringJoiner;

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
    protected StringBuilder processorVersion = new StringBuilder();
    private Integer valueOfCheap = 0;
    private Scanner informationScanner;
    private static LinkedList<String> stringArrayList = new LinkedList<>();

    public LocalProcessor(String processorName, Long period, StringBuilder processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, LinkedList<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(LinkedList<String> stringList) {
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
