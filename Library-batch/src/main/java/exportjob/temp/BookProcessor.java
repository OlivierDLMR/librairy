package exportjob.temp;

import library.book.Book;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.batch.api.chunk.ItemProcessor;
import java.util.logging.Logger;

@Component
public class BookProcessor implements ItemProcessor<String, BookDto> {

    private static final Logger logger = LoggerFactory.getLogger(BookProcessor.class);

    private CustomerService customerService;

    @Override
    public BookDto process(final String customerId) throws Exception {
        final Book customer = customerService.findOne(customerId);
        logger.info("Processing Customer {}", customer);

        return BookDto;
    }
}

