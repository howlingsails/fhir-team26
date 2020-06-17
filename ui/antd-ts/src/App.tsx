import React, {FC} from 'react';
import {Card, Empty, Layout} from 'antd';
import './App.css';
import {FhirPageHeader} from "./FhirPage";

const { Header, Footer, Sider, Content } = Layout;

const App: FC = () => (

    <div className="App">
        <Layout>
            <Sider>
                <Card size="small" title="Current Health Records" extra={<a href="#">More</a>} style={{width: 300}}>
                    <p>Doctor #1</p>
                    <p>Doctor #2</p>
                    <p>Doctor #3</p>
                </Card>
            </Sider>
            <Layout>
                <Header>
                    <FhirPageHeader onBack={() => window.history.back()}/>

                </Header>
                <Content><Empty style={{height: 300,verticalAlign:"middle"}}></Empty></Content>
                <Footer>Create with Love by Team 26</Footer>
            </Layout>
        </Layout>

    </div>
);

export default App;