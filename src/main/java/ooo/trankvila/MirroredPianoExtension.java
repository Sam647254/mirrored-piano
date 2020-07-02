package ooo.trankvila;

import com.bitwig.extension.api.util.midi.ShortMidiMessage;
import com.bitwig.extension.callback.ShortMidiMessageReceivedCallback;
import com.bitwig.extension.controller.ControllerExtension;
import com.bitwig.extension.controller.api.ControllerHost;
import com.bitwig.extension.controller.api.Transport;

public class MirroredPianoExtension extends ControllerExtension {
    protected MirroredPianoExtension(final MirroredPianoExtensionDefinition definition, final ControllerHost host) {
        super(definition, host);
    }

    @Override
    public void init() {
        final ControllerHost host = getHost();

        mTransport = host.createTransport();
        host.getMidiInPort(0).setMidiCallback((ShortMidiMessageReceivedCallback) this::onMidi0);
        host.getMidiInPort(0).setSysexCallback(this::onSysex0);

        // TODO: Perform your driver initialization here.
        // For now just show a popup notification for verification that it is running.
        host.showPopupNotification("Mirrored Piano Initialized");
    }

    @Override
    public void exit() {
        // TODO: Perform any cleanup once the driver exits
        // For now just show a popup notification for verification that it is no longer running.
        getHost().showPopupNotification("Mirrored Piano Exited");
    }

    @Override
    public void flush() {
        // TODO Send any updates you need here.
    }

    /**
     * Called when we receive short MIDI message on port 0.
     */
    private void onMidi0(ShortMidiMessage msg) {
        // TODO: Implement your MIDI input handling code here.
    }

    /**
     * Called when we receive sysex MIDI message on port 0.
     */
    private void onSysex0(final String data) {
        // MMC Transport Controls:
        switch (data) {
            case "f07f7f0605f7":
                mTransport.rewind();
                break;
            case "f07f7f0604f7":
                mTransport.fastForward();
                break;
            case "f07f7f0601f7":
                mTransport.stop();
                break;
            case "f07f7f0602f7":
                mTransport.play();
                break;
            case "f07f7f0606f7":
                mTransport.record();
                break;
        }
    }

    private Transport mTransport;
}
