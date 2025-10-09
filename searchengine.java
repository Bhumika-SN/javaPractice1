import java.util.*;

public class SimpleSearchEngine {

    // Inverted index: word -> list of document IDs
    private Map<String, Set<Integer>> invertedIndex = new HashMap<>();
    private List<String> documents = new ArrayList<>();

    // Adds a document to the search engine
    public void addDocument(String document) {
        int docId = documents.size();
        documents.add(document);

        String[] words = document.toLowerCase().split("\\W+"); // Split on non-word characters
        for (String word : words) {
            invertedIndex
                .computeIfAbsent(word, k -> new HashSet<>())
                .add(docId);
        }
    }

    // Search for documents containing the keyword
    public List<String> search(String keyword) {
        keyword = keyword.toLowerCase();
        Set<Integer> docIds = invertedIndex.getOrDefault(keyword, Collections.emptySet());
        List<String> results = new ArrayList<>();

        for (int id : docIds) {
            results.add(documents.get(id));
        }

        return results;
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        SimpleSearchEngine engine = new SimpleSearchEngine();

        engine.addDocument("The quick brown fox jumps over the lazy dog.");
        engine.addDocument("Java is a high-level, class-based programming language.");
        engine.addDocument("The fox is clever and fast.");
        engine.addDocument("Dogs are loyal animals.");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a keyword to search: ");
        String keyword = scanner.nextLine();

        List<String> results = engine.search(keyword);

        if (results.isEmpty()) {
            System.out.println("No documents found containing the keyword: " + keyword);
        } else {
            System.out.println("Documents containing '" + keyword + "':");
            for (String doc : results) {
                System.out.println("- " + doc);
            }
        }

        scanner.close();
    }
}
