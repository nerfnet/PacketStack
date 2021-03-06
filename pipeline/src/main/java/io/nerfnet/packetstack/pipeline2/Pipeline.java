package io.nerfnet.packetstack.pipeline2;


import java.util.List;
import java.util.UUID;

/**
 * Created by Giovanni on 15/01/2018.
 */
public interface Pipeline<E> {

    /**
     * Returns the identifier of this group.
     *
     * @return The identifier.
     */
    String identifier();

    /**
     * Returns the {@link PipelineEnd} of this pipeline.
     *
     * @return The ending of this pipeline.
     */
    PipelineEnd ending();

    /**
     * Transfers incoming data to a {@link PipelineEnd} which then handles the data.
     *
     * @param data The data that aims for the end of a pipeline.
     * @param end  The ending pipeline which the data has to be transported to.
     * @return itself
     */
    Pipeline<E> transfer(E data, PipelineEnd end);

    /**
     * Moves the ending of this pipeline to a new {@link PipelineEnd}.
     *
     * @param newEnd The new {@link PipelineEnd}.
     * @return itself connected to a new {@link PipelineEnd}
     */
    Pipeline<E> movePipelineEnding(PipelineEnd newEnd);

    /**
     * Closes this pipeline and returns a {@link ClosedPipeline}.
     *
     * @return The closed version of this pipeline.
     */
    ClosedPipeline close();

    /**
     * Returns whether this Pipeline is closed or not.
     *
     * @return State
     */
    boolean closed();

}
