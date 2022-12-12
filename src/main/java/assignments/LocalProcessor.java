package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private StringBuffer processorName;
    private Long period = 10_000_000_000_000L;
    protected StringBuffer processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private static LinkedList<String> stringArrayList = new LinkedList<>();

    public LocalProcessor(StringBuffer processorName, Long period, StringBuffer processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, LinkedList<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        LocalProcessor.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(LinkedList<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);
        for (int i = 0; i < period; i++) {
            System.out.println(stringArrayList.get(i).hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public StringBuffer fullNameProcessorGenerator(LinkedList<String> stringList) {
        for (int i = 0; i < stringArrayList.size(); i++) {
            processorName.append(stringList.get(i)).append(' ');
        }
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
            informationScanner = new Scanner(file);
            while (informationScanner.hasNext()) {
                processorVersion.append(informationScanner.nextLine());
            }

    }
}
