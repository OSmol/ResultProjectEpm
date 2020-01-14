package by.javatr.result.factory;

import by.javatr.result.service.ClientService;
import by.javatr.result.service.LibraryService;
import by.javatr.result.service.impl.ClientServiceImpl;
import by.javatr.result.service.impl.LibraryServiceImpl;

public final class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final ClientService clientService = new ClientServiceImpl();
    private final LibraryService libraryService = new LibraryServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public ClientService getClientService() {
        return clientService;
    }

    public LibraryService getLibraryService() {
        return libraryService;
    }
}
