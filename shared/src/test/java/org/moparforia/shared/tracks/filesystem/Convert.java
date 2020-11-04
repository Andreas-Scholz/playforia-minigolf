package org.moparforia.shared.tracks.filesystem;

import org.moparforia.shared.tracks.parsers.TrackConverter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Convert {
    public static void main(String[] args) throws URISyntaxException, IOException {
        URL resource = Convert.class.getClassLoader().getResource("v1/tracks");
        Path srcPath = Paths.get(resource.toURI());

        TrackConverter.convertTracks(srcPath);
    }
}
