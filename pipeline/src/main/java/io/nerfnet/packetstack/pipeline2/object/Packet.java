package io.nerfnet.packetstack.pipeline2.object;

import io.nerfnet.packetstack.pipeline2.simple.SimplePipeline;
import org.apache.commons.lang.SerializationUtils;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * Created by Giovanni on 15/01/2018.
 */
public class Packet implements Serializable {

    private String pipeline;
    private int requestedEnding;
    private final Operation operation;
    private transient final byte[] pipelineData;

    public Packet(Operation operation, int requestedEnding, Serializable object) {
        this.operation = operation;
        this.requestedEnding = requestedEnding;
        this.pipelineData = SerializationUtils.serialize(object);

    }

    public Operation getOperation() {
        return operation;
    }

    /**
     * Returns the current pipeline this packet is on.
     *
     * @return The current pipeline.
     */
    public String getPipeline() {
        return pipeline;
    }

    /**
     * Returns the object that has been sent over the pipeline.
     *
     * @return The object.
     */
    public Object read() {
        return SerializationUtils.deserialize(pipelineData);
    }

    /**
     * Returns the preferred {@link io.nerfnet.packetstack.pipeline2.PipelineEnd}'s id of this packet.
     *
     * @return Preferred PipelineEnd's id.
     */
    public int getRequestedEnding() {
        return requestedEnding;
    }

    public void setCurrentPipeline(@Nonnull SimplePipeline pipeline) {
        this.pipeline = pipeline.identifier();
    }
}