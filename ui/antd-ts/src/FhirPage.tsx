import React, {Component} from "react";
import {Button, Descriptions, PageHeader} from "antd";

export class FhirPageHeader extends Component<{ onBack: () => void }> {
    render() {
        return <PageHeader
            ghost={false}
            onBack={this.props.onBack}
            title="FHIR Document Retriever"
            subTitle="Gather Your Health"
            extra={[
                <Button key="3">Add Health Records</Button>,
                <Button key="2">Push All Health Records</Button>,
            ]}
        >
        </PageHeader>;
    }
}